// document.getElementById('signup-form').addEventListener('submit', function(e) {
//     e.preventDefault();
//     const username = document.getElementById('signup-username').value;
//     const password = document.getElementById('signup-password').value;

//     // Simulating signup process
//     console.log('Signup:', { username, password });

//     // Clear the form
//     document.getElementById('signup-form').reset();
// });

// document.getElementById('login-form').addEventListener('submit', function(e) {
//     e.preventDefault();
//     const username = document.getElementById('login-username').value;
//     const password = document.getElementById('login-password').value;

//     // Simulating login process
//     console.log('Login:', { username, password });

//     // On successful login, redirect with a header
//     if (username && password) {
//         const headers = new Headers();
//         headers.append('Authorization', 'Bearer your-jwt-token');
//         const requestOptions = {
//             method: 'GET',
//             headers: headers,
//             redirect: 'follow'
//         };

//         fetch('http://localhost:8005', requestOptions)
//             .then(response => {
//                 if (response.ok) {
//                     window.location.href = 'http://localhost:8005';
//                 } else {
//                     console.error('Login failed');
//                 }
//             })
//             .catch(error => console.error('Error:', error));
//     }

//     // Clear the form
//     document.getElementById('login-form').reset();
// });


function toggleForms() {
    const signupForm = document.getElementById('signup-form');
    const loginForm = document.getElementById('login-form');
    signupForm.classList.toggle('hidden');
    loginForm.classList.toggle('hidden');
}

function signup() {
    const username = document.getElementById('signup-username').value;
    const password = document.getElementById('signup-password').value;

    // Simulating signup process
    console.log('Signup:', { username, password });

    // Clear the form
    document.getElementById('signup-username').value = '';
    document.getElementById('signup-password').value = '';
}

function login() {
    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-password').value;

    // Simulating login process
    console.log('Login:', { username, password });

    // On successful login, redirect with a header
    if (username && password) {
        const headers = new Headers();
        headers.append('Authorization', 'Bearer your-jwt-token');
        const requestOptions = {
            method: 'GET',
            headers: headers,
            redirect: 'follow'
        };

        fetch('http://localhost:8005', requestOptions)
            .then(response => {
                if (response.ok) {
                    window.location.href = 'http://localhost:8005';
                } else {
                    console.error('Login failed');
                }
            })
            .catch(error => console.error('Error:', error));
    }

    // Clear the form
    document.getElementById('login-username').value = '';
    document.getElementById('login-password').value = '';
}
