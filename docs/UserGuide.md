---
layout: page
title: User Guide
---

* Table of Contents:
{:toc}

--------------------------------------------------------------------------------------------------------------------

## 1. Introduction

*MyInsuRec* is **the desktop app for financial advisors**. If you are a financial advisor looking for an app to better manage your clients, meetings and products details, then look no further. *MyInsuRec* can also boost your productivity with features to quickly look up client and meetings details. Beyond that, *MyInsuRec* also has features to help you improve your customer relations.

*MyInsuRec* is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, *MyInsuRec* can get your client, meeting and product management tasks done faster than traditional GUI apps.

*MyInsuRec* is available for the Windows, macOS and Linux operating systems.

--------------------------------------------------------------------------------------------------------------------

## 2. About

### 2.1 Using this User Guide

Welcome to *MyInsuRec User Guide*!

This guide explains how you can use *MyInsuRec* to organize and manage your clients, meetings and products. This guide has been structured for users to quickly find and understand what they need.

Click on the links below to quickly get to what you need.

{ fill with instructions linking to different sections of the user guide }

e.g.
1. xyz (link)
2. 


### 2.2 Symbols

| Symbol               | Meaning                                                                       |
|----------------------|-------------------------------------------------------------------------------|
| `command`            | Indicates some command or parameter that can be entered into MyInsuRec's CLI. |
| :information_source: | Additional information that can be helpful.                                   |
| :exclamation:        | Crucial information that you should be aware of.                              |


### 2.3 Terminologies

The following explains some terminology and main features of *MyInsuRec*:

#### 2.3.1 Clients

At the heart of *MyInsuRec* is the ability to organize and keep track of clients. You can do client-specific tasks such as:

* add a client and their details into *MyInsuRec*.
* view a client and their details, such as any upcoming meetings and purchased products.
* update a client's details.
* delete a client from *MyInsuRec*.

Beyond individual clients, you can also:

* show a summarized list of all clients with their important details such as contact number, products bought.
* filter and display a summarized list of clients with upcoming birthdays to help boost your customer relations.
* filter and display a summarized list of clients who purchased a specific product.

#### 2.3.2 Meetings

*MyInsuRec* eases a financial advisor's mental load by helping them track of any upcoming meetings. You can do meeting-specific tasks such as:

* add a meeting to a client in *MyInsuRec*.
* view a meeting in greater details.
* update a meeting's details.
* delete a meeting from a client in *MyInsuRec*.

Beyond individual meetings, you can also:

* show a summarized list of all meetings with their important details such as meeting date and time.
* quickly get a glance of tomorrow's meetings, and also in the coming week and month.

#### 2.3.3 Products

In order to help track a client's purchases, *MyInsuRec* also includes the ability for users to define products that a client might have purchased. You can do product-specific tasks such as:

* add a product to *MyInsuRec*.
* delete a product from *MyInsuRec*.

Beyond individual products, you can also:

* show a summarized list of all products.

### 2.4 User Interface

{ replace with a diagram of MyInsuRec and arrows and notes describing the different components of MyInsuRec }

### 2.5 Quick Start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `MyInsuRec.jar` from [here](https://github.com/AY2223S1-CS2103T-W16-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your MyInsuRec.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds.
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    1. `viewClient`: View a particular client
    2. `addClient`: Add a client
    3. `delClient`: Delete client

1. Refer to the [Features](#3-features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 3. Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by you.<br>
  e.g. in `addClient n/NAME p/PHONE_NUMBER`, `NAME` and `PHONE_NUMBER` are parameters which can be used as `addClient n/John Tan p/12345678`.

* Items in square brackets are optional, while those not in square brackets are compulsory.<br>
  e.g. `addClient n/NAME p/PHONE_NUMBER [a/ADDRESS] [e/EMAIL] [b/BIRTHDAY] [pd/PRODUCT]` can be used as <br>
  * `addClient n/John Tan p/12345678`
  * `addClient n/John p/12345678 e/John@abc.com b/12122000`

* This symbol `||` indicates that only one of the optional parameters can be used. <br> 
  **Using more than one optional parameter is strictly not allowed.** <br>
  e.g. `listClient [pd/PRODUCT || b/BIRTHDAY]` can be used as 
  * `listClient pd/Product1`
  * `listClient b/week`

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `d/28092022 d/30092022`, only `d/30092022` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `exit` and `help`) will be ignored.<br>
  e.g. if the command specifies `exit 123`, it will be interpreted as `exit`.

</div>

### 3.1 Client commands

#### 3.1.1 Add client: `addClient`

Add a new client to MyInsuRec.

Format: `addClient n/NAME p/PHONE_NUMBER [a/ADDRESS] [e/EMAIL] [b/BIRTHDAY] [pd/PRODUCT]`

* A client must have a `NAME` and a `PHONE_NUMBER`.
* `EMAIL`, `BIRTHDAY`, `ADDRESS` and `PRODUCT` are optional.

<div markdown="block" class="alert alert-warning">:exclamation: **Caution:**
In order to use `pd/PRODUCT` as a parameter, you must have already added that product into MyInsuRec via `addProduct`. See [addProduct](#331-adding-a-product-addproduct).
</div>

Examples:
* `addClient n/John Tan p/12345678`
* `addClient n/John Tan p/12345678 b/12122000`
* `addClient n/John Tan p/12345678 e/johntan@insurec.com a/123 ABC ROAD, #11-01 pd/Product1`

#### 3.1.2 List clients: `listClient`

* List clients in MyInsuRec with a valid filter.
* A valid filter can be clients who have bought the product `PRODUCT` or clients whose birthday is in range `BIRTHDAY`
* `BIRTHDAY` is specified by keywords. The possible keywords are:
    * `tomorrow` for a list of clients whose birthday is tomorrow;
    * `week` for a list of clients whose birthday is in the next week;
    * `month` for a list of clients whose birthday is in the next month.

Format: `listClient [pd/PRODUCT || b/BIRTHDAY]`

Examples:
* `listClient`
* `listClient pd/Product1`
* `listClient b/week`

<div markdown="block" class="alert alert-info">:exclamation: **Caution:** Both filters cannot exist simultaneously. A user can only apply one filter at each time. For example, `listClient pd/Product1 b/week` is strictly not allowed.
</div>

#### 3.1.3 View client: `viewClient`

View details associated with a client, such as the client's name and phone number.

Format: `viewClient i/INDEX`

* Display information about the client at the specific `INDEX`.
* The index refers to the index number shown in the displayed clients' list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `viewClient i/1`

#### 3.1.4 Delete client: `delClient`

Delete the specified client from MyInsuRec.

Format: `delClient i/INDEX`

* Delete the client at the specified `INDEX`.
* `INDEX` refers to the index number shown by executing [`listClient`](#312-list-clients-listclient) command.
* `Index` **must be a positive integer** 1, 2, 3, …​

Examples:
* `delClient i/2`

#### 3.1.5 Edit client: `editClient`

Edit detail of the specified client.

Format: `editClient i/INDEX [n/NAME] [p/PHONE_NUMBER] [a/ADDRESS] [e/EMAIL] [b/BIRTHDAY] [pd/PRODUCT]`

* Edit the client at the specified `INDEX`.
*`INDEX` refers to the index number shown by executing [`listClient`](#312-list-clients-listclient) command.
* `INDEX` **must be a positive integer** 1, 2, 3, …​
* At least one optional detail must be modified.
* Maintain value of details not edited by the command.

Examples:
Suppose MyInsuRec contains only one client 'John Tan' having phone number '0123456789':
* `editClient i/1 n/John Smith` changes the name of this client to 'John Smith'.
* `editClient i/1 e/johntan@insurec.com`adds the email 'johntan@insurec.com' to the client.

### 3.2 Meeting commands

#### 3.2.1 Add meeting: `addMeeting`

Add a new meeting to MyInsuRec.
DATE should be in DD-MM-YYYY format and TIME should be in 24-hour format.

Format: `addMeeting i/INDEX d/DATE t/TIME dn/DESCRIPTION`

* Add a meeting.
* A meeting contains the `INDEX` of the client in the clients list, the `DATE` and `TIME` for the meeting, and the `DESCRIPTION` of the meeting.

Examples:
* `addMeeting i/1 d/28092022 t/1400 dn/Team meeting`

#### 3.2.2 List meetings: `listMeeting`

Show a list of meetings in MyInsuRec.
If used with optional parameter `[d/DATE]`, *MyInsuRec* will show a list of meetings happening in that time period.

Format: `listMeeting [d/DATE]`

* Time periods are specified by keywords. The possible keywords are:
  * `tomorrow` for a list of meetings happening tomorrow;
  * `week` for a list of meetings happening in the next week;
  * `month` for a list of meetings happening in the next month.

Examples:
* `listMeeting d/tomorrow`
* `listMeeting d/month`

#### 3.2.3 View meeting: `viewMeeting`

View detail associated with a meeting, such as meeting's date and time.

Format: `viewMeeting i/INDEX`

* Display information about the meeting at the specific `INDEX`.
* The index refers to the index number shown in the displayed meetings' list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `viewMeeting i/1`

#### 3.2.4 Delete meeting: `delMeeting`

Delete a meeting from MyInsuRec.

Format: `delMeeting i/INDEX`

* Delete the meeting at the specified `INDEX`.
* `INDEX` refers to the index number shown by executing [`listMeeting`](#322-list-meetings-listmeeting) command.
* `INDEX` **must be a positive integer** 1, 2, 3, …​

Examples:
* `delMeeting i/2`

#### 3.2.5 Edit meeting: `editMeeting`

Edit details of the specified meeting.

Format: `editMeeting i/INDEX [d/DATE] [st/START TIME] [et/END TIME] [dn/DESCRIPTION]`

* Edit information about the meeting at the specific `INDEX`.
* The `INDEX` refers to the index number shown in the displayed meetings' list.
* The index **must be a positive integer** 1, 2, 3, …​
* At least one optional detail must be modified.
* Maintain values of details not edited by the command.

Examples:
Suppose MyInsuRec contains only one meeting as created in the [`addMeeting`](#321-add-meeting-addmeeting) command:
* `editMeeting i/1 dn/Follow up team meeting` changes the description of this meeting.
* `editMeeting i/1 st/1500 et/1200` will show error saying invalid time since start time is later than end time.

### 3.3 Product commands

#### 3.3.1 Add product: `addProduct`

Add a new product to MyInsuRec.

Format: `addProduct pd/PRODUCT`

* Add a product having name `PRODUCT`.
* A product must have a product name which is `PRODUCT`.

Examples:
* `addProduct pd/Product1`

#### 3.3.2 List products: `listProduct`

Show a list of all products in MyInsuRec.

Format: `listProduct`

#### 3.3.3 Delete product: `delProduct`

Delete a product from MyInsuRec.  
This feature will remove the product from association with any client.

Format: `delProduct i/INDEX`

* Delete the product at the specified `INDEX`.
* The index refers to the index number shown in the displayed product list.
* The index **must be a positive integer** 1, 2, 3, …​

<div markdown="block" class="alert alert-warning">:exclamation: **Caution:**
This feature should only be used if there is a need to delete a product, which is unlikely in most conceivable scenario! Use with caution as this not only removes the product from MyInsuRec's product list, it also removes the product from any association with your clients.
</div>

Examples:
* `delProduct i/2`

### 3.4 General commands

#### 3.4.1 View help: `help`

Show a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

#### 3.4.2 Exit MyInsuRec: `exit`

Exit the program.

Format: `exit`

### 3.5 Others

#### 3.5.1 Save the data

MyInsuRec data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

#### 3.5.2 Edit the data file

MyInsuRec data are saved as a JSON file `[JAR file location]/data/myinsurec.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, MyInsuRec will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## 4. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app, then overwrite the `myinsurec.json` file created by the app with the version of the file from the previous computer.

**Q**: I accidentally closed the app, will my data still be there?<br>
**A**: Yes, your data is saved automatically after every action.

**Q**: My computer does not recognise the file type jar. How do I open the app?<br>
**A**: Install Java version 11 and above from the official Java website.

--------------------------------------------------------------------------------------------------------------------

## 5. Command summary

| Action                                               | Format                                                                                         | Examples                                                                                                                                         |
|------------------------------------------------------|------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| [**Add client**](#311-add-client-addclient)          | `addClient n/NAME p/PHONE_NUMBER [a/ADDRESS] [e/EMAIL] [b/BIRTHDAY] [pd/PRODUCT]`              | • `addClient n/John Tan p/12345678` <br> • `addClient n/John Tan p/12345678 a/123 ABC ROAD, #11-01 e/johntan@insurec.com b/12122000 pd/Product1` |
| [**List clients**](#312-list-clients-listclient)     | <code>listClient [pd/PRODUCT &#124;&#124; b/BIRTHDAY]</code>                                   | • `listClient` <br> • `listClient pd/Product1` <br> • `listClient b/tomorrow` <br> • `listClient b/week` <br> • `listClient b/month`             |
| [**View client**](#313-view-client-viewclient)       | `viewClient i/INDEX`                                                                           | • `viewClient i/1`                                                                                                                               |
| [**Delete client**](#314-delete-client-delclient)    | `delClient i/INDEX`                                                                            | • `delClient i/1`                                                                                                                                |
| [**Edit client**](#315-edit-client-editclient)       | `editClient i/INDEX [n/NAME] [p/PHONE_NUMBER] [a/ADDRESS] [e/EMAIL] [b/BIRTHDAY] [pd/PRODUCT]` | • `editClient i/1 n/John Smith`                                                                                                                  |
| [**Add meeting**](#321-add-meeting-addmeeting)       | `addMeeting i/INDEX d/DATE t/TIME dn/DESCRIPTION`                                              | • `addMeeting i/1 d/28092022 t/1400 dn/Team meeting`                                                                                             |
| [**List meetings**](#322-list-meetings-listmeeting)  | `listMeeting [d/DATE]`                                                                         | • `listMeeting` <br> • `listMeeting d/tomorrow` <br> • `listMeeting d/week`  <br> • `listMeeting d/month`                                        |
| [**View meeting**](#323-view-meeting-viewmeeting)    | `viewMeeting i/INDEX`                                                                          | • `viewMeeting i/1`                                                                                                                              |
| [**Delete meeting**](#324-delete-meeting-delmeeting) | `delMeeting i/INDEX`                                                                           | • `delMeeting i/1`                                                                                                                               |
| [**Edit meeting**](#325-edit-meeting-editmeeting)    | `editMeeting i/INDEX [d/DATE] [st/START TIME] [et/END TIME] [dn/DESCRIPTION]`                  | • `i/1 dn/Follow up team meeting`                                                                                                                |
| [**Add product**](#331-add-product-addproduct)       | `addProduct pd/PRODUCT`                                                                        | • `addProduct pd/Product1`                                                                                                                       |
| [**List products**](#332-list-products-listproduct)  | `listProduct`                                                                                  | • `listProduct`                                                                                                                                  |
| [**Delete product**](#333-delete-product-delproduct) | `delProduct i/INDEX`                                                                           | • `delProduct i/1`                                                                                                                               |
| [**Help**](#341-view-help-help)                      | `help`                                                                                         | `help`                                                                                                                                           |
| [**Exit**](#342-exit-myinsurec-exit)                 | `exit`                                                                                         | `exit`                                                                                                                                           |

--------------------------------------------------------------------------------------------------------------------

## 6. Glossary

{ glossary placeholder }
