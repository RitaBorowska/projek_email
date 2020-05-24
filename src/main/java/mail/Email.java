package mail;

public class Email {

    private final String mailAdress;
    private final String subject;
    private final String concent;
    private boolean sent;

    public Email(String mailAdress, String subject, String concent) {
        this.mailAdress = mailAdress;
        this.subject = subject;
        this.concent = concent;
        sent = false;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public String getSubject() {
        return subject;
    }

    public String getConcent() {
        return concent;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }


}