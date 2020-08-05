package step_definitions;

import framework_utilities.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import page_objects.StrongerTogether_PageObjects;
import test_data_variables.Constants;

import java.util.Map;

public class StrongerTogether_Steps {
    public Scenario scenario;

    TestDataReader testDataReaderObj = new TestDataReader();
    UiUtilities uiUtilitiesObj = new UiUtilities();

    public StrongerTogether_Steps() {
        scenario = CucumberHooks._scenario;
    }

    @And("I read and write the table in excel sheet")
    public void iReadAndWriteTheTableInExcelSheet(DataTable table) throws Exception {
        for (Map<String, String> data : table.asMaps()) {
            readAndWriteTheTableInExcelSheet(data);
        }
    }

    public void readAndWriteTheTableInExcelSheet(Map<String, String> data) throws Exception {
        String fileName = testDataReaderObj.readData(data.get("<File>"));
        By tableRows = By.xpath("//tr");
        int rowsCount = uiUtilitiesObj.getElementCount(StrongerTogether_PageObjects.tbl_FeedTheCity,tableRows);
        for(int row=1;row<=rowsCount;row++) {
            By tableCols = By.xpath("//tr["+row+"]/td/p");
            int colCount = uiUtilitiesObj.getElementCount(StrongerTogether_PageObjects.tbl_FeedTheCity,tableCols);
            for(int col=1;col<=colCount;col++) {
                By tableData = By.xpath("//tr["+row+"]/td["+col+"]/p");
                String cellData = uiUtilitiesObj.getTextFromChildElement(StrongerTogether_PageObjects.tbl_FeedTheCity,tableData);
                System.out.println(cellData);
                ExcelUtils.writeCellData(Constants.ExcelFilesPath + fileName,row-1, col-1,cellData);
            }
        }
        scenario.write("Table data is updated in the following Excel file "+Constants.ExcelFilesPath + fileName);
    }


}
