package in.rajesh.galla;

import javax.mail.*;
import javax.mail.search.AndTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.SearchTerm;
import java.util.Properties;

/**
 * Created by Galla on 2/27/2015.
 */
public class RetrieveEmail {

    public String getEmail(final String host, final String username, final String password,
                           final String recipientAddressString) throws Exception {

        Message message = getMessage(host,username, password, recipientAddressString);
        String emailContent = getEmailContent(message);
        return emailContent;
    }

    public String getEmail(Message message) throws Exception {

        String emailContent = getEmailContent(message);
        return emailContent;
    }

    public Message getMessage(final String host, final String username, final String password, final String recipientAddressString) throws Exception {

        Folder inbox = getFolder(getStore(host, username, password), "INBOX");
        if(inbox == null) throw new NullPointerException("No messages found");
        System.out.println();
        System.out.println("Search terms recipientAddressString:" + recipientAddressString);
        System.out.println();
        SearchTerm[] searchTerms = { new RecipientStringTerm(Message.RecipientType.TO, recipientAddressString)};
        Message[] messages = getMessages(inbox, searchTerms);
        if(messages == null) throw new NullPointerException("No messages found");

        return messages[0];
    }

    protected Folder getFolder(Store store, String folderName) throws Exception {
        return store.getFolder(folderName);
    }

    protected Message[] getMessages(Folder folder, SearchTerm[] searchTerms) throws Exception {
        Message[] messages;
        folder.open(Folder.READ_WRITE);
        messages = folder.getMessages();
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

        return message.getContent().toString();
    }
}