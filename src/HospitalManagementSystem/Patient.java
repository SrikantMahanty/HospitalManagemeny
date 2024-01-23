package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Patient {

    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }


    public void addPatient() {
        System.out.println("Enter Patient Name :");
        String name = scanner.nextLine();
        System.out.println("Enter Patient Age :");
        int age = scanner.nextInt();
        System.out.println("Enter Patient Gender :");
        String gender = scanner.nextLine();

        try {
            String q = "insert into patient(name,age,gender)values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, gender);
            preparedStatement.setInt(3, age);
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                System.out.println("Inserted values in the database successfully..");
            } else {
                System.out.println("Some error ocuurs ::");
            }

        } catch (Exception e) {

        }
    }
    public void viewPatients(){
        String q="Select * from patient";

        try {

            PreparedStatement preparedStatement=connection.prepareStatement(q);
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println("Patients ;");
            System.out.println("+----+----------------+----------------+");
            System.out.println("|patient id | Name   |Age |Gender|");
            System.out.println("+----+----------------+----------------+");
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("Name");
                int  afe=resultSet.getInt("Age");
                String gender=resultSet.getString("Gender");
                System.out.printf("|%-10s|%-20s|%-12s|%-10s\n",id,name,afe);


            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean getPatientById(int id){
        String q="Select * from patient where id =?";
        try{

            PreparedStatement preparedStatement=connection.prepareStatement(q);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return  true;
            }else{
                return  false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  false;
    }

}
