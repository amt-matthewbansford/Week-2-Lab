package Pages;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileDownloadPage extends Setup {
    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "File Download")
    private WebElement fileDownload;

    @FindBy(linkText = "Download")
    private List<WebElement> downloadButton;

    @FindBy(css = "input[name='password']")
    private WebElement downloadPassword;

    @FindBy(css = "iframe#wpdm-lock-frame")
    private WebElement downloadFrame;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public void openDownloadPage() throws InterruptedException {
        scrollIntoView(fileDownload);
        sleep(3000);
        fileDownload.click();
    }

    public void clickDownloadButton1() throws InterruptedException {
        downloadButton.getFirst().click();
        sleep(5000);
    }


    public void assertDownload() throws IOException {
        String userHome = System.getProperty("user.home");
        String downloadPath = userHome + "\\Downloads\\test.pdf";

        File downloadFile = new File(downloadPath);
        if (downloadFile.exists()) {
            System.out.println("PDF File is downloaded");

            try (PDDocument document = PDDocument.load(downloadFile)) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String content = pdfStripper.getText(document);

                System.out.println(content);


                if (content.contains("This is a sample PDF file")) {
                    System.out.println("File content is correct");
                } else {
                    System.out.println("File content is incorrect");
                }
            }
        }
                else{
                System.out.println("PDF Download failed");
            }
        }

        public void clickDownloadButton2 () throws InterruptedException {
            downloadButton.getLast().click();
            switchToFrame(downloadFrame);
            sleep(5000);
        }

        public void enterDownloadPassword (String password){
            downloadPassword.sendKeys(password);
        }

        public void clickSubmit() throws InterruptedException {
            submitButton.click();
            sleep(5000);
        }

    public void assertDownload2() throws IOException {
        String userHome = System.getProperty("user.home");
        String downloadPath = userHome + "\\Downloads\\test.docx";

        File downloadFile = new File(downloadPath);
        if (downloadFile.exists()) {
            System.out.println(".DOCX File is downloaded");

            try (FileInputStream fis = new FileInputStream(downloadFile);
                 XWPFDocument document = new XWPFDocument(fis)) {

                List<XWPFParagraph> paragraphs = document.getParagraphs();
                StringBuilder contentBuilder = new StringBuilder();

                for (XWPFParagraph paragraph : paragraphs) {
                    contentBuilder.append(paragraph.getText()).append("\n");
                }

                String content = contentBuilder.toString();
                System.out.println(content);

                if (content.contains("This is a sample .docx file")) {
                    System.out.println("File content is correct");
                } else {
                    System.out.println("File content is incorrect");
                }
            }
        } else {
            System.out.println("DOCX Download failed");
        }
    }
}
