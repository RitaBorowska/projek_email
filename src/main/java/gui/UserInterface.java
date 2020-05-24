package gui;

import mail.Email;
import mail.MailService;

import java.awt.color.ColorSpace;
import java.util.Scanner;

public class UserInterface {

        public  static  final  String SPACE = ".........................";
        private MailService mailService;

    public UserInterface(MailService mailService) {
        this.mailService = mailService;
    }

    public void  showMenu(){

        System.out.println("Witaj w aplikacji SDA email");
        System.out.println("...........................");
        System.out.println("Wybierz co chcesz zrobic");
        System.out.println("1. wyslij email");
        System.out.println("2. wyjscie");
        System.out.println(SPACE);
    }

        public void listen(Scanner scanner) {

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    sendEmail(scanner);
                    break;
                case 2:
                    System.out.println("wychodze z programu");
                    System.exit(0);
                    break;
            }
        }

    private void sendEmail( Scanner scanner) {
        System.out.println("podaj email:");
        String mail = scanner.next();
        System.out.println("podaj temat email");
        String subject = scanner.next();
        System.out.println("podaj tesc email");
        String  content = scanner.next();

        Email email = new Email(mail, subject, content);

        new Thread(() -> sendEmail(scanner)).start();
//        mailService.sendEmail(email);


    }

    public void start(Scanner scanner) {
        while (true){
            showMenu();
            listen(scanner);

        }
    }
}
