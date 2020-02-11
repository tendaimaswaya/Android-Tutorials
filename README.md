# Android-Tutorials
 Different code snippets to get you neatly started with Android development and Kotlin

* API URL -: https://tutorialsapi.herokuapp.com/api/
//Hitting this endpoint will give you a whitelabel error - it does not have a fallback. Use the complete endpoints below instead

# Login-Retrofit
* Users: https://tutorialsapi.herokuapp.com/api/users
* User Login details(sample) can be acquired from hitting the 'users' endpoint
* Just incase this Heroku endpoint is not responding due to minimal usage, here is the raw JSON:

[{"userId":"tendai1","userName":"Tendai Test","userPassword":"tendai1","userToken":"xz87yHS7"},{"userId":"lee2","userName":"Leslie Test","userPassword":"lee2","userToken":"xR35rIT7"},{"userId":"tinashe3","userName":"Tinashe Test","userPassword":"tinashe3","userToken":"df87sDT6"},{"userId":"prob4","userName":"Probity Test","userPassword":"prob4","userToken":"er87yFB0"},{"userId":"ten5","userName":"Tendai Test2","userPassword":"ten5","userToken":"nk45tGR9"}]

Copy that and make sure it is saved as .json before consuming, that's if the endpoint is down

# Recyclerview-JSON-Retrofit
* View JSON Response products in a recyclerview via Retrofit API call
* Product: https://tutorialsapi.herokuapp.com/api/products
* You can view the JSON response by hitting the 'products' endpoint

* Just in case as stated above, here is the raw JSON:

[{"id":"1","product":"Huawei P30","image":"https://i.gadgets360cdn.com/products/large/1553612597_635_huawei_p30_pro.jpg","datePosted":"10-12-2019"},{"id":"2","product":"iPhone XS","image":"https://csmobiles.com/19721-large_default/apple-iphone-xs-64gb-gray.jpg","datePosted":"10-12-2019"},{"id":"3","product":"Google Pixel 4","image":"https://icdn2.digitaltrends.com/image/digitaltrends/pixel-4-xl-rear-sticking-out.jpg","datePosted":"10-12-2019"},{"id":"4","product":"Samsung S10","image":"https://csmobiles.com/27310-large_default/samsung-galaxy-s10-g973f-128gb-dual-sim-red.jpg","datePosted":"10-12-2019"},{"id":"5","product":"Xiaomi MI 9","image":"https://fdn2.gsmarena.com/vv/bigpic/xiaomi-mi-9-.jpg","datePosted":"10-12-2019"}]
