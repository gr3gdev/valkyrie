module.exports = {
    extends: [
        'eslint:recommended',
        'plugin:@typescript-eslint/recommended',
        'plugin:vue/vue3-recommended',
    ],
    parser: 'vue-eslint-parser',
    parserOptions: {
        "parser": "@typescript-eslint/parser",
        "sourceType": "module"
    },
    plugins: ['vue', '@typescript-eslint'],
    root: true,
    rules: {
        'vue/max-attributes-per-line': 'off',
        'vue/singleline-html-element-content-newline': 'off',
        'vue/html-self-closing': 'off'
    }
}