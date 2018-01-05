import java.util.Hashtable;

/*
 * Class: ContactsDstabase
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

public class ContactsDstabase
{
    volatile Hashtable<String, String> contactslist = new Hashtable<String, String>();

    public ContactsDstabase()
    {
        super();
        System.err.println("Creating contacts database...");
    }

    public Hashtable<String, String> getInstance()
    {
        return this.contactslist;
    }
}
