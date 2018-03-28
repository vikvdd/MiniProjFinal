package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    private Program program;


    @FXML
    private Label investorNameLbl;
    @FXML
    private Label comCodeLbl;
    @FXML
    private Label comNameLbl;
    @FXML
    private Label sharePriceLbl;
    @FXML
    private Label sharesOwnedLbl;
    @FXML
    private Label netValLbl;
    @FXML
    private ListView sharesLV;
    @FXML
    private ListView marketLV;
    @FXML
    private Button viewCompBtn1;
    @FXML
    private Button viewCompBtn2;


    @FXML
    public void initialize() throws IOException
    {
        //starts new program
        program = new Program();

        //loads company data files and sets them up
        program.getStockMarket().getMarkets().get(0).readCompaniesFiles();
        setupPortFolioCompanies();

        //updates user data to UI
        investorNameLbl.setText(program.getInvestor().getName());

        //update shares and market lists
        loadMarketsListView();
        loadSharesListView();

        //update company details panel
        setComDetView(program.getInvestor().getPortfolio().getCompanies().get(0));

        //start scheduled event timer
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                program.getStockMarket().randomEvent();
                program.getStockMarket().getCurrentEvent().setPercentImpact();

                for (int i = 0; i < program.getStockMarket().getMarkets().size(); i++)
                {
                    program.getStockMarket().getMarkets().get(i).eventMarketUpdate(program.getStockMarket().getCurrentEvent());
                }
                for (int i = 0; i < program.getInvestor().getPortfolio().getCompanies().size(); i++)
                {
                    program.getInvestor().getPortfolio().getCompanies().get(i).eventStatUpdate(program.getStockMarket().getCurrentEvent());
                }
            }
        }, 1*60*1000, 1*60*1000);
    }

    //creates various dummy companies for example purposes
    public void setupPortFolioCompanies()
    {
        for (int i = 0; i < program.getStockMarket().getMarkets().size(); i++)
        {
            program.getInvestor().getPortfolio().setOwnedCompanies(program.getStockMarket().getMarkets().get(i));
        }
    }

    //fills in company details in based on given company
    public void setComDetView(Company company)
    {
        comCodeLbl.setText(company.getCode() + "");
        comNameLbl.setText(company.getName() + "");
        sharePriceLbl.setText(company.getShareVal() + "");
        sharesOwnedLbl.setText(company.getSharesOwned() + "");
        netValLbl.setText(company.getNetValue() + "");
        return;
    }

    //finds selected company and calls method to fill in details
    public void sharesListViewClick()
    {
        if (sharesLV.getSelectionModel().getSelectedItems() != null)
        {
            ObservableList<String> selectedItem = sharesLV.getSelectionModel().getSelectedItems();
            Company company = program.getInvestor().getPortfolio().getCompany(selectedItem.get(0));
            program.setDisplayShares(true);
            setComDetView(company);
        }
        return;
    }

    //set company info pane to display info on selected market comp
    public void marketListViewClick()
    {
        if (marketLV.getSelectionModel().getSelectedItems() != null)
        {
            ObservableList<String> selectedItem = marketLV.getSelectionModel().getSelectedItems();
            Company company = program.getStockMarket().getMarkets().get(0).getCompany(selectedItem.get(0));
            program.setDisplayShares(false);
            setComDetView(company);
        }

        return;
    }

    //load all the owned companies into the shares list view
    public void loadSharesListView()
    {

        sharesLV.getItems().addAll(program.getInvestor().getPortfolio().getCompaniesStr());
        return;
    }

    //load all the market companies into the market listview
    public void loadMarketsListView()
    {
        for (int i = 0; i < program.getStockMarket().getMarkets().size(); i++)
        {
            marketLV.getItems().addAll(program.getStockMarket().getMarkets().get(i).getCompaniesStr());
        }
        return;
    }

    public void buySellShare()
    {

        if (program.getDisplayShares())
        {
            ObservableList<String> selectedItem = sharesLV.getSelectionModel().getSelectedItems();
            program.getInvestor().getPortfolio().getCompany(selectedItem.get(0)).removeShare();

        }
        else if (!program.getDisplayShares())
        {
            ObservableList<String> selectedItem = marketLV.getSelectionModel().getSelectedItems();
            program.getInvestor().getPortfolio().getCompany(selectedItem.get(0)).addShare();
            loadMarketsListView();
        }
    }

}
