import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('REC57-ADM01 log'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Semaine/Profil'))

WebUI.click(findTestObject('Page_Semaine/MonProfil'))

WebUI.selectOptionByValue(findTestObject('Page_Semaine/select_Langue'), 'FR', false)

WebUI.click(findTestObject('Page_Semaine/input_Langue_btn btn-primary'))

WebUI.click(findTestObject('Page_Semaine/CONFIG'))

WebUI.click(findTestObject('Page_Configuration/Notifications'))

WebUI.click(findTestObject('NOTIFICATIONS/CREER_notif_button'))

WebUI.selectOptionByValue(findTestObject('NOTIFICATIONS/select_Event'), Event, false)

if (Origine != 'Tous') {
    System.out.println(('*****  Origine= ' + Origine) + ' *****')

    WebUI.selectOptionByValue(findTestObject('NOTIFICATIONS/select_Origine'), Origine, false)
}

//System.out.println(SC)
if (Jobtype_Opt == true) {
    System.out.println(('*****  JobType= ' + Jobtype_Opt) + ' *****')

    System.out.println(('*****  JobType= ' + Jobtype) + ' *****')

    WebUI.click(findTestObject('NOTIFICATIONS/span_Job Type'))

    WebUI.setText(findTestObject('NOTIFICATIONS/input_Jobtype-focused'), Jobtype)

    WebUI.sendKeys(findTestObject('NOTIFICATIONS/input_Jobtype-focused'), Keys.chord(Keys.ENTER))
}

if (Client_Opt == true) {
    WebUI.click(findTestObject('NOTIFICATIONS/div_Client'))

    WebUI.setText(findTestObject('NOTIFICATIONS/input_Client-focused'), Client)

    WebUI.sendKeys(findTestObject('NOTIFICATIONS/input_Client-focused'), Keys.chord(Keys.ENTER))

    System.out.println(('*****  Client= ' + Client_Opt) + ' *****')

    System.out.println(('*****  Client= ' + Client) + ' *****')
}

WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('NOTIFICATIONS/select_Desti'), Sendto, false)

WebUI.setText(findTestObject('NOTIFICATIONS/input_customDesti'), Email)

WebUI.setText(findTestObject('NOTIFICATIONS/input_Title_message_title'), MsgTitre)

WebUI.setText(findTestObject('NOTIFICATIONS/textarea_Message_message_content'), Msg)

WebUI.sendKeys(findTestObject('NOTIFICATIONS/textarea_Message_message_content'), Keys.chord(Keys.ENTER))

if (Delay_Opt == true) {
    System.out.println(('*****  Delay= ' + Delay_Opt) + ' *****')

    System.out.println(('*****  Delay= ' + Delay) + ' *****')

    WebUI.check(findTestObject('NOTIFICATIONS/checkbox_Delay'))

    WebUI.setText(findTestObject('NOTIFICATIONS/input_Delay'), Delay)

    WebUI.selectOptionByValue(findTestObject('NOTIFICATIONS/select_hours'), DelayUnit, false)
}

if (Once_Opt == true) {
    System.out.println(('*****  Once= ' + Once_Opt) + ' *****')

    WebUI.check(findTestObject('NOTIFICATIONS/checkbox_Onlyonce'))
}

WebUI.takeScreenshot(SC)

WebUI.click(findTestObject('NOTIFICATIONS/Notif_saveBtn'))

WebUI.verifyElementPresent(findTestObject('NOTIFICATIONS/td_Email Custom testNotif01gmail.com'), 0)

