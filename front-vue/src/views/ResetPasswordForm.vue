<script setup lang="ts">
import { UserIcon } from "@heroicons/vue/24/solid";
import axios from "axios";
import { ref } from "vue";

const form = ref(null);
const username = ref("");

const handleResetPassword = () => {
  if (form.value) {
    const htmlForm = form.value as HTMLFormElement;
    if (htmlForm.reportValidity()) {
      axios
        .post("http://localhost:9000/resetPassword", {
          username: username.value,
        })
        .then((res) => console.log("TODO reset password", res));
    }
  }
};
</script>

<template>
  <form ref="form" class="mx-auto" @submit.prevent="handleResetPassword">
    <div class="my-4">
      <label for="username">{{ $t("labels.username") }}</label>
      <div class="flex h-8">
        <UserIcon class="flex-initial icon" />
        <input
          id="username"
          v-model="username"
          class="flex-shrink text-icon"
          type="text"
          name="username"
          placeholder="Username"
          autocomplete="username"
        />
      </div>
    </div>
    <button type="submit">
      {{ $t("buttons.reset") }}
    </button>
  </form>
  <div class="footer">
    <router-link to="/login">{{ $t("backToLogin") }}</router-link>
  </div>
</template>
