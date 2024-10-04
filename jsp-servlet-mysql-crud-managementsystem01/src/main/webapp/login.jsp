<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Include Bulma CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    
     <style>
        /* Custom styles */
        body, h1, h2, h3, h4, h5, h6, p, a, button, input, select, textarea {
            font-family: 'Roboto', sans-serif !important;
        }
        
		
    </style>
    
</head>
<body>

<section class="hero is-fullheight is-light">
    <div class="hero-body">
        <div class="container">
            <div class="columns is-centered">
                <!-- Wrapper div for the form -->
                <div class="column is-4 box"> <!-- Box gives it a card-like appearance -->
                    <h1 class="title has-text-centered">Login</h1>

                    <form action="<%=request.getContextPath()%>/login" method="POST">
                        <!-- Username -->
                        <div class="field">
                            <label class="label">Username</label>
                            <div class="control has-icons-left">
                                <input class="input" type="text" name="username" placeholder="" required>
                                <span class="icon is-small is-left">
                                    <i class="fas fa-user"></i>
                                </span>
                            </div>
                        </div>

                        <!-- Password -->
                        <div class="field">
                            <label class="label">Password</label>
                            <div class="control has-icons-left">
                                <input class="input" type="password" name="password" placeholder="" required>
                                <span class="icon is-small is-left">
                                    <i class="fas fa-lock"></i>
                                </span>
                            </div>
                        </div>

                        <!-- Submit Button -->
                        <div class="field">
                            <div class="control">
                                <button class="button is-primary is-fullwidth">Login</button>
                            </div>
                        </div>
                    </form>
                    
                </div> <!-- End of wrapper div -->
            </div>
        </div>
    </div>
</section>

<!-- FontAwesome for icons -->
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

</body>
</html>
