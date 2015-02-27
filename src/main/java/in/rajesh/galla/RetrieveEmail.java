package in.rajesh.galla;

import javax.mail.*;
import javax.mail.search.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by Galla on 2/27/2015.
 */
public class RetrieveEmail {

    public static void main(String srgs[]) throws Exception {
        RetrieveEmail retrieveEmail = new RetrieveEmail();
        Message message = retrieveEmail.getMessage("imap.gmail.com",
                "ilovecoingattokyo@gmail.com","codingattokyo","ilovecodingattokyo@gmail.com","ilovecodingattokyo@gmail.com","Hi ra");
        String emailContent = retrieveEmail.getEmailContent(message);
        System.out.println(emailContent);
    }

    private Message getMessage(final String host, final String username, final String password,
                               final String recipientAddressString, final String fromAddress, final String subject) throws Exception {
        boolean isMailFound = false;
        Message messageSearched = null;
        Folder inbox = getFolder(getStore(host, username, password), "INBOX");
        if(inbox == null) throw new NullPointerException("No messages found");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        SearchTerm[] searchTerms = {new SentDateTerm(ComparisonTerm.GE, calendar.getTime()),
                new FromStringTerm(fromAddress), new SubjectTerm(subject),
                new RecipientStringTerm(Message.RecipientType.TO, recipientAddressString)};
        Message[] messages = getMessages(inbox, searchTerms);
        if(messages == null) throw new NullPointerException("No messages found");
        if(!messages[0].isSet(javax.mail.Flags.Flag.SEEN) && messages[0].getSubject().equalsIgnoreCase(subject)) {
            messageSearched = messages[0];
            isMailFound = true;
        }
        if(!isMailFound) throw new Exception("Email could not be found");
        return messageSearched;
    }

    protected Folder getFolder(Store store, String folderName) throws Exception {
        return store.getFolder(folderName);
    }

    protected Message[] getMessages(Folder folder, SearchTerm[] searchTerms) throws Exception {
        Message[] messages;
        folder.open(Folder.READ_WRITE);
        long startTime = System.nanoTime();
        do{
            Thread.sleep(50000);
            messages = folder.getMessages();
            if(System.nanoTime() - startTime/(1000000000 * 60) >= 5 ) break;
        }while(messages.length == 0);
        if(messages == null) throw new NullPointerException("No messages found");
        return folder.search(new AndTerm(searchTerms), messages);
    }


    protected Store getStore(final String host, final String username, final String password) throws Exception {

        Session session = Session.getDefaultInstance(new Properties(), new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);    //To change body of overridden methods use File | Settings | File Templates.
            }
        });

        Store store = session.getStore("imaps");
        store.connect(host, username, password);
        return store;
    }

    protected String getEmailContent(Message message) throws Exception {
        String line;
        StringBuffer buffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(message.getInputStream()));
        while ((line = bufferedReader.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }


}
