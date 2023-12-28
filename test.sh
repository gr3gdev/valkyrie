#!/bin/bash
cd front-vue
npm run build
export PAGES_DIRECTORY="file:$(pwd)/dist/"
echo "$PAGES_DIRECTORY"
cd ..
./gradlew app:bootRun