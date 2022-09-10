const loginForm = document.getElementById('login-form');
const loginUsername= document.getElementById('login-username');
const loginPassword = document.getElementById('login-password');

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users';

console.log("Document.cookie :  " + document.cookie );
const handleSubmit = async (evt) =>{
    evt.preventDefault();
    console.log("Login HandleSubmit")
    console.log("Login .js  base URL :" + baseUrl)
    let bodyObj = {
        username: loginUsername.value,
        password: loginPassword.value
    }
    const response = await fetch(`${baseUrl}/login`,{
        method :"POST",
        body:JSON.stringify(bodyObj),
        headers:headers
    })
    .catch(err => console.error(err.message))

    const responseArr = await response.json()
    console.log("Login HandleSubmit after response" + responseArr)
    console.log(responseArr[1])
    if(response.status === 200){
      document.cookie = `userId=${responseArr[1]}`
        window.location.replace(responseArr[0])
    }
}
loginForm.addEventListener("submit",handleSubmit)