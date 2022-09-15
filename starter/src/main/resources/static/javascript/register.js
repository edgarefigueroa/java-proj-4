const registerForm = document.getElementById('register-form')
const registerUsername= document.getElementById('register-username')
const registerPassword = document.getElementById('register-password')

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

const handleSubmit = async (evt) =>{
    console.log("Register HandleSubmit")
    console.log("Register .js  base URL :" + baseUrl)
    evt.preventDefault();
    let bodyObj = {
        username: registerUsername.value,
        password: registerPassword.value
    }
    const response = await fetch(`${baseUrl}/register`,{
        method :"POST",
        body:JSON.stringify(bodyObj),
        headers:headers
    })
    .catch(err => console.error(err.message))

    const responseArr = await response.json()
    console.log("Register HandleSubmit" + responseArr)
    if(response.status === 200){
        window.location.replace(responseArr[0]);
    }
}
//register form
registerForm.addEventListener('submit',handleSubmit)