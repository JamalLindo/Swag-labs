# Web GUI Testing Project (Swag Labs)


**Overview:**
This project provides a GUI testing framework for Swaglabs website (https://www.saucedemo.com/).

**Project structure:**

The project provides a Page Object Model (POM) for testers to use. The POM has been already tested and it abstracts away the webdriver and provides helper methods that make testing easier.

**Drivers:**
- DriverFactory - This is a class that has webdriver options that are being passed to the DriverOptions class. These options include: CHROME, SAFARI, FIREFOX and CHROME_IPHONE13 drivers.
- DriverOptions - This is an enum class that is acting as a connecting point between POMs and the webdrivers declared under the DriverFactory class.

**POMUtils:**

Because the webdriver file is located under the resource directory, it is included under the .gitignore file. Therefore, assuming that a tester who wants to use this framework might want to put their driver file in a different path, the POMUtils class provides a different method that does not ask for the path of the driver file and it provides flexibility for testers to use different types of webdrivers.

**Pages:**
- LoginPage - This class has the password and usernames used for the login. Test methods for the login page (https://www.saucedemo.com/) are also declared under this class. These methods include tests for all accepted usernames listed on the login page. Moreover, assuming that a user might insert a username that does not match any user in this service, we have provided a method for this case that tests the error message returned as a response for this invalid username.
- HomePage - This class has test methods for the home page (https://www.saucedemo.com/inventory.html). These methods include tests for adding and removing available products to/from the cart.
- CheckoutPage - Test methods for the logout button located under the sidebar.
NavigationPage -

**Tests:**

These are the test classes prepared for testers to be used based on the test methods previously created under the Pages package. Classes created under the Tests package include:
- HomePageTests.
- LoginPageTests.
- NavigationPageTests.

## Instructions to Run the Programme

