# KDAY03 - Mocking The Internet

This lab will explore how to gain control over the network requests and responses to and from your Android app, without rewriting the app itself. We will be using the [Atlantis](https://github.com/echsylon/atlantis) library for this.

## *EXERCISE 1:* Mimic the not-yet-existing backend API.

In this exercise we'll look at a very early development scenario; the customer has some ideas and would like to see some real life app views. The backend isn't ready yet and the API only exist on paper yet.

The mission:

1. The customer wants a recipe app where a set of dishes are shown in a main list view. Each list item should show an image of the dish, the name of it and maybe some more useful info.

2. Clicking on a list item should open up a new view, where more detailed information is found and the steps to prepare the dish is listed.

3. Note! There is no backend ready at the moment, so you will have to mock the data, but when the backend development gets going, it will be ready quite quickly and there won't be much time to "rewrite the app".

With above in mind, write your app and impress the customer.

## *EXERCISE 2:* Write stable unit tests for your network layer.

This exercise will address how to test the network behavior of your app. How do you trigger an HTTP 404 response at will, without involving all the uncertainty a real network request may induce (no network, the servers being slow etc)?

1. Take the network layer from the previous exercise (or any other app you may have laying around), you can also write a small custom app using Google Volley or similar for this purpose if you don't have a working candidate.

2. Make sure your app targets a real (working) API. [`http://echo.jsontest.com`](http://echo.jsontest.com) may reach out a helping hand in this endeavor.

3. Use Atlantis and the [Java API](https://github.com/echsylon/atlantis/wiki) for testing the behavior of your app for different network responses. You can configure Atlantis to deliver a wide range of HTTP responses. You can even delay a response by a certain amount of time.

4. Still using Atlantis, verify that your app makes the network requests it's supposed to make and in the correct order. Verify that it aborts when an error response is returned.

Free your mind, and remember: there is no spoon!
