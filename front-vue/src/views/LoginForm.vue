<script setup lang="ts">
import UsernameField from "../components/UsernameField.vue";
import PasswordField from "../components/PasswordField.vue";
import axios from "axios";
import { ref } from "vue";

const form = ref(null);
const username = ref("");
const password = ref("");

const handleLogin = () => {
  if (form.value) {
    const htmlForm = form.value as HTMLFormElement;
    if (htmlForm.reportValidity()) {
      axios
        .post("/login", {
          username: username.value,
          password: password.value,
        })
        .then((res) => console.log("TODO login", res));
    }
  }
};
</script>

<template>
  <form ref="form" class="mx-auto" @submit.prevent="handleLogin">
    <UsernameField v-model:username="username" />
    <PasswordField v-model:password="password" />
    <button type="submit">
      {{ $t("buttons.login") }}
    </button>
  </form>
  <div class="my-4">
    <router-link to="/resetPassword">{{ $t("labels.forgotPassword") }}</router-link>
  </div>
  <div class="footer">
    {{ $t("newUser") }}
    <router-link to="/register">{{ $t("buttons.register") }}</router-link>
  </div>
</template>
