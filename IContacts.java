/*
 * Class: IContacts
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

public interface IContacts
{
    void createNewContact() throws InterruptedException;

    void deleteAllContacts();

    void deleteContact();

    void editContact();

    void getAllContacts();

    void getContact();

    void listContacts();

    void searchContacts();

    void setContact();

    void sortContacts();

}
