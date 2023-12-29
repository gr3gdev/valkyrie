<script setup lang="ts">
import FirstnameField from "../components/FirstnameField.vue";
import LastnameField from "../components/LastnameField.vue";
import UsernameField from "../components/UsernameField.vue";
import NewPasswordFields from "../components/NewPasswordFields.vue";
import NewEmailFields from "../components/NewEmailFields.vue";
import { useRouter } from "vue-router";
import axios from "axios";
import { ref } from "vue";

const router = useRouter();
const form = ref(null);
const firstname = ref("");
const lastname = ref("");
const username = ref("");
const password = ref("");
const confirmPassword = ref("");
const email = ref("");
const confirmEmail = ref("");

const handleRegister = () => {
  if (form.value) {
    const htmlForm = form.value as HTMLFormElement;
    if (htmlForm.reportValidity()) {
      axios
        .post("http://localhost:9000/register", {
          firstname: firstname.value,
          lastname: lastname.value,
          username: username.value,
          password: password.value,
          confirmPassword: confirmPassword.value,
          email: email.value,
          confirmEmail: confirmEmail.value,
        })
        .then(() => {
          router.push("/login");
        })
        .catch((err) => {
          if (err) {
            for (const [field, message] of Object.entries(err.response.data)) {
              console.error(field, message);
              // TODO show dialog with errors
            }
          }
        });
    }
  }
};
</script>

<template>
  <dialog class="error">
    <p class="firstname hidden"></p>
    <p class="lastname hidden"></p>
    <p class="username hidden"></p>
    <p class="password hidden"></p>
    <p class="email hidden"></p>
    <p class="userModel hidden"></p>
  </dialog>
  <form ref="form" class="mx-auto" @submit.prevent="handleRegister">
    <FirstnameField v-model:firstname="firstname" />
    <LastnameField v-model:lastname="lastname" />
    <UsernameField v-model:username="username" />
    <NewPasswordFields
      v-model:password="password"
      v-model:confirm-password="confirmPassword"
      :error-mismatch="$t('errors.password.mismatch')"
    />
    <NewEmailFields
      v-model:email="email"
      v-model:confirm-email="confirmEmail"
      :error-mismatch="$t('errors.email.mismatch')"
    />
    <button type="submit">
      {{ $t("buttons.register") }}
    </button>
  </form>
  <div class="footer">
    <router-link to="/login">{{ $t("backToLogin") }}</router-link>
  </div>
</template>
