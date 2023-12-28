import { createApp } from 'vue'
import { createI18n } from 'vue-i18n'
import { createRouter, createWebHistory } from 'vue-router'

import './style.css'
import App from './App.vue'

import en from './locales/en.json'
import fr from './locales/fr.json'
import LoginFormVue from './components/LoginForm.vue'
import RegisterFormVue from './components/RegisterForm.vue'
import ResetPasswordFormVue from './components/ResetPasswordForm.vue'

const i18n = createI18n({
    locale: 'en',
    fallbackLocale: 'en',
    messages: {
        en: en,
        fr: fr
    },
})

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/login', name: 'Login', component: LoginFormVue },
        { path: '/register', name: 'Register', component: RegisterFormVue },
        { path: '/resetPassword', name: 'ResetPassword', component: ResetPasswordFormVue }
    ]
})

createApp(App)
    .use(router)
    .use(i18n)
    .mount('#app')
