/*
 * Class: Contacts
 *
 * Created on 26-Dec-2017
 *
 * (c) Copyright Lam Research Corporation, unpublished work, created 2017
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Lam Research Corporation
 * 4000 N. First Street
 * San Jose, CA
 */

public class Contacts implements IContacts, Runnable
{
    static ContactsDstabase dstabase = new ContactsDstabase();

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(new Contacts());
        thread.start();
    }

    public Contacts()
    {
        super();
        System.err.println("Contacts Application.");
    }

    synchronized public void createNewContact() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            Contacts.dstabase.getInstance().put("name", "jitendra" + Math.random());
        }

        Thread.sleep(10000);
    }

    public void deleteAllContacts()
    {
        // TODO Auto-generated method stub

    }

    public void deleteContact()
    {
        // TODO Auto-generated method stub

    }

    public void editContact()
    {
        // TODO Auto-generated method stub

    }

    synchronized public void getAllContacts()
    {
        for (int i = 0; i < 10000; i++)
        {
            System.err.println(Contacts.dstabase.getInstance().get("name" + Math.random()));
        }

    }

    public void getContact()
    {
        // TODO Auto-generated method stub

    }

    public void listContacts()
    {
        // TODO Auto-generated method stub

    }

    public void run()
    {
        try
        {
            this.createNewContact();
            this.getAllContacts();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public void searchContacts()
    {
        // TODO Auto-generated method stub

    }

    public void setContact()
    {
        // TODO Auto-generated method stub

    }

    public void sortContacts()
    {
        // TODO Auto-generated method stub

    }
}
