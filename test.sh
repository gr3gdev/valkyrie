#!/bin/bash
curl -v "http://localhost:9000/oauth2/authorize?response_type=code&client_id=valkyrie&redirect_uri=http://127.0.0.1:5173/&state=V0123456789&code_challenge=6d419592be13b89433cbe93d3d0c03b0f143ff9cef54f359c46b57918ddf3215&code_challenge_method=S256"

#curl -v -X POST "http://localhost:9000/oauth2/token" --data "client_id=valkyrie" --data "client_secret=secret" --data "code=???" --data "grant_type=authorization_code" --data "redirect_uri=http://127.0.0.1:5173" --data "code_verifier=6d419592be13b89433cbe93d3d0c03b0f143ff9cef54f359c46b57918ddf3215"
