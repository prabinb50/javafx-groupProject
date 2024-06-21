package org.example.groupproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {
    // admin for login
    @FXML
    private Label userINFO;

    @FXML
    private Label LoginINFO;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;




    // admin for register
    @FXML
    private TextField adminName;

    @FXML
    private TextField adminEmail;

    @FXML
    private  TextField adminUsername;

    @FXML
    private PasswordField adminPassword;

    @FXML
    private PasswordField adminConfirmPassword;


    //survey creator for login
    @FXML
    private TextField SurveyCreatorEmail;

    @FXML
    private PasswordField SurveyCreatorPassword;

    // survey creator for register
    @FXML
    private TextField creatorName;

    @FXML
    private TextField creatorEmail;

    @FXML
    private TextField creatorUsername;

    @FXML
    private ChoiceBox<String> creatorGender;

    @FXML
    public void initialize(){
        if(creatorGender != null){
            creatorGender.getItems().addAll("male", "female", "others");
        } else{
            System.err.println("error");
        }
    }

    @FXML
    private TextField creatorFaculty;

    @FXML
    private TextField creatorNo;

    @FXML
    private PasswordField creatorPassword;

    @FXML
    private PasswordField creatorConfirmPassword;



    // participant for login
    @FXML
    private TextField ParticipantEmail;

    @FXML
    private PasswordField ParticipantPassword;

    // participant for register
    @FXML
    private TextField participantSignUpName;

    @FXML
    private TextField participantSignUpEmail;

    @FXML
    private TextField participantSignUpUsername;

//    @FXML
//    private ChoiceBox<String> participantSignUpGender;

//    @FXML
//    public void initializeG(){
//        if(participantSignUpGender != null){
//            participantSignUpGender.getItems().addAll("male", "female", "others");
//        } else{
//            System.err.println("error");
//        }
//    }

    @FXML
    private TextField participantSignUpFaculty;

    @FXML
    private TextField participantSignUpNo;

    @FXML
    private PasswordField participantSignUpPassword;

    @FXML
    private PasswordField participantSignUpConfirmPassword;






    // path of csv files
    String pathToCSV = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\AdminData.csv";
    String pathToCSVCreator = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\Creator.csv";
    String pathOfCSVParticipant = "C:\\Users\\acer\\IdeaProjects\\GroupProject\\src\\main\\resources\\org\\example\\groupproject\\Participant.csv";



    // starting page
    public void buttonForAdminSignIn() throws IOException{
        loadStage("/org/example/groupproject/Admin.fxml");
    }

    public void buttonForCreatorSignIn() throws IOException{
        loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
    }

    public void buttonForParticipantSignIn() throws IOException{
        loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
    }




    // for admin......................
    // for login
    public void buttonForAdminSignUp(ActionEvent event) throws IOException{
        // loadStage("AdminSignUp.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminSignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = StageUtils.extractStageFromEvent(event);
        stage.setScene(scene);
    }

    public void buttonForLogin(ActionEvent event){
        String emailText = email.getText();
        String passwordText = password.getText();
        try {
            FileReader fileReader = new FileReader(pathToCSV);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] rows;
            boolean found = false;
            while ((rows = csvReader.readNext()) != null){
                if (emailText.equals(rows[1]) && passwordText.equals(rows[3])){
                    LoginINFO.setText("Login Successful");
                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = StageUtils.extractStageFromEvent(event);
                    stage.setScene(scene);
                    found = true;
                    break;
                }
            }
            if (!found) {
                LoginINFO.setText("Invalid Credentials");
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    // for register
    public void buttonForAdminRegister() {
        String AdminName = adminName.getText();
        String AdminEmail = adminEmail.getText();
        String AdminUsername = adminUsername.getText();
        String AdminPassword = adminPassword.getText();
        String AdminConformPassword = adminConfirmPassword.getText();
        try {
            FileWriter fileWriter = new FileWriter(pathToCSV, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {AdminName, AdminEmail, AdminUsername, AdminPassword, AdminConformPassword};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("/org/example/groupproject/Admin.fxml");

        } catch (Exception e) {
            userINFO.setText(e.getMessage());
        }
    }

    public void buttonForAdminLogin()throws IOException{
        loadStage("/org/example/groupproject/Admin.fxml");
    }




    // survey creator...........................................
    // for login
    public void buttonForSurveyCreatorSignUp(ActionEvent event) throws IOException{
        // loadStage("AdminSignUp.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyCreatorSignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = StageUtils.extractStageFromEvent(event);
        stage.setScene(scene);
    }

    public void buttonForSurveyCreatorLogin(ActionEvent event){
        String emailText = SurveyCreatorEmail.getText();
        String passwordText = SurveyCreatorPassword.getText();
        try {
            FileReader fileReader = new FileReader(pathToCSVCreator);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] rows;
            boolean found = false;
            while ((rows = csvReader.readNext()) != null){
                if (emailText.equals(rows[1]) && passwordText.equals(rows[6])){
                    LoginINFO.setText("Login Successful");
                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = StageUtils.extractStageFromEvent(event);
                    stage.setScene(scene);
                    found = true;
                    break;
                }
            }
            if (!found) {
                LoginINFO.setText("Invalid Credentials");
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    // for register
    public void buttonForCreatorRegister(ActionEvent event) {
        String CreatorName = creatorName.getText();
        String CreatorEmail = creatorEmail.getText();
        String CreatorUsername = creatorUsername.getText();
        String CreatorGender = creatorGender.getValue();
        String CreatorFaculty = creatorFaculty.getText();
        String CreatorNo = creatorNo.getText();
        String CreatorPassword = creatorPassword.getText();
        String CreatorConformPassword = creatorConfirmPassword.getText();
        try {
            FileWriter fileWriter = new FileWriter(pathToCSVCreator, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {CreatorName, CreatorEmail, CreatorUsername, CreatorGender, CreatorFaculty, CreatorNo, CreatorPassword, CreatorConformPassword};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
        } catch (Exception e) {
            userINFO.setText(e.getMessage());
        }
    }

    public void buttonForCreatorLogin()throws IOException{
        loadStage("/org/example/groupproject/Survery CreatorSignIn.fxml");
    }






    // participant...........................................
    // for login
    public void buttonForParticipantSignUp(ActionEvent event) throws IOException{
        // loadStage("AdminSignUp.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ParticipantSignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = StageUtils.extractStageFromEvent(event);
        stage.setScene(scene);
    }

    public void buttonForParticipantLogin(ActionEvent event){
        String emailText = ParticipantEmail.getText();
        String passwordText = ParticipantPassword.getText();
        try {
            FileReader fileReader = new FileReader(pathOfCSVParticipant);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] rows;
            boolean found = false;
            while ((rows = csvReader.readNext()) != null){
                if (rows.length >= 7 && emailText.equals(rows[1]) && passwordText.equals(rows[6])){ // Check row length before accessing
                //if (emailText.equals(rows[1]) && passwordText.equals(rows[6])){
                    LoginINFO.setText("Login Successful");
                    //loadStage("/org/example/groupproject/AdminDashboard.fxml");
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = StageUtils.extractStageFromEvent(event);
                    stage.setScene(scene);
                    found = true;
                    break;
                }
            }
            if (!found) {
                LoginINFO.setText("Invalid Credentials");
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    // for register
    public void buttonForParticipantSignUpRegister(ActionEvent event) {
        String ParticipantName = participantSignUpName.getText();
        String ParticipantEmail = participantSignUpEmail.getText();
        String ParticipantUsername = participantSignUpUsername.getText();
        String ParticipantGender = creatorGender.getValue();
        String ParticipantFaculty = participantSignUpFaculty.getText();
        String ParticipantNo = participantSignUpNo.getText();
        String ParticipantPassword = participantSignUpPassword.getText();
        String ParticipantConformPassword = participantSignUpConfirmPassword.getText();
        try {
            FileWriter fileWriter = new FileWriter(pathOfCSVParticipant, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {ParticipantName, ParticipantEmail, ParticipantUsername, ParticipantGender, ParticipantFaculty, ParticipantNo, ParticipantPassword, ParticipantConformPassword};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
        } catch (Exception e) {
            userINFO.setText(e.getMessage());
        }
    }

    public void buttonForParticipantSignUpLogin()throws IOException{
        loadStage("/org/example/groupproject/ParticipantSignIn.fxml");
    }








    @FXML
    public void loadStage(String sceneName) throws IOException{
        try {
            System.out.println("Loading FXML file: " + sceneName);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sceneName));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) userINFO.getScene().getWindow();
            stage.setScene(new Scene (root));
            stage.show();
        }catch (IOException e){
            userINFO.setText("Failed to load scene: " + e.getMessage());
            e.printStackTrace();
        }
    }
}