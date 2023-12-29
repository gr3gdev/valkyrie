#!/bin/bash

# Generate Code Verifier
#> bw4CWS3M1hdKOLQZpFCW1nZjHNkORLcYsPq56_3p48Z6k1IG

# Generate Code Challenge
#> 1USdr3ksk71O0WtmN2JMkQXC58D09E1A3PJ1Xp5aDjE

# Build the Authorization URL
#> GET https://authorization-server.com/authorize
# response_type=code
# client_id=DiNuyYnTx6OTPPy-gyCVmUjo
# redirect_uri=https://www.oauth.com/playground/authorization-code-with-pkce.html
# scope=photo+offline_access
# state=Dh8w8iR-St58PoRp
# code_challenge=1USdr3ksk71O0WtmN2JMkQXC58D09E1A3PJ1Xp5aDjE
# code_challenge_method=S256

# Login & Approuve

# Verify the State parameter
#> ?state=Dh8w8iR-St58PoRp&code=VRJB6ihKQC5vndk4c3LhUTz0aNzllbolqvxK0fLQFGlDRazT

# Exchange the Authorization Code 
#> POST https://authorization-server.com/token
# grant_type=authorization_code
# client_id=DiNuyYnTx6OTPPy-gyCVmUjo
# client_secret=S5316O6A8ZUj7zPR9mHutdqZEmMSvTQjN3bBOUJ_CaOGqgJ_
# redirect_uri=https://www.oauth.com/playground/authorization-code-with-pkce.html
# code=VRJB6ihKQC5vndk4c3LhUTz0aNzllbolqvxK0fLQFGlDRazT
# code_verifier=bw4CWS3M1hdKOLQZpFCW1nZjHNkORLcYsPq56_3p48Z6k1IG

# Token Endpoint Response
# {
#   "token_type": "Bearer",
#   "expires_in": 86400,
#   "access_token": "FjUq_-BaU7aAXEzjIbWw8a2lAAcrrNu7hQYuyLjCwvkldWK_bSrP9TyRGKwFpb9ygXvzWVyv",
#   "scope": "photo offline_access",
#   "refresh_token": "QpQY-NPLtq8AVJkvFxelAsDL"
# }

curl -v "http://localhost:9000/oauth2/authorize?response_type=code&client_id=valkyrie&redirect_uri=http://127.0.0.1:5173/&state=V0123456789&code_challenge=6d419592be13b89433cbe93d3d0c03b0f143ff9cef54f359c46b57918ddf3215&code_challenge_method=S256"

#curl -v -X POST "http://localhost:9000/oauth2/token" --data "client_id=valkyrie" --data "client_secret=secret" --data "code=???" --data "grant_type=authorization_code" --data "redirect_uri=http://127.0.0.1:5173" --data "code_verifier=6d419592be13b89433cbe93d3d0c03b0f143ff9cef54f359c46b57918ddf3215"
