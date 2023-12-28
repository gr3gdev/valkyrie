<script setup lang="ts">
import { LockClosedIcon } from "@heroicons/vue/24/solid";
import { ref } from "vue";
const passwordElement = ref(null);
const confirmPasswordElement = ref(null);
const props = defineProps({
  password: {
    default: "",
    type: String,
  },
  confirmPassword: {
    default: "",
    type: String,
  },
  errorMismatch: {
    default: "Passwords are not the same",
    type: String,
  },
});
const emits = defineEmits(["update:password", "update:confirmPassword"]);
const checkPasswordMatches = () => {
  if (passwordElement.value && confirmPasswordElement.value) {
    const password = passwordElement.value as HTMLInputElement;
    const confirmPassword = confirmPasswordElement.value as HTMLInputElement;
    const passwordValue = password.value;
    const confirmPasswordValue = confirmPassword.value;
    if (passwordValue && confirmPasswordValue && passwordValue !== confirmPasswordValue) {
      confirmPassword.setCustomValidity(props.errorMismatch);
    } else {
      confirmPassword.setCustomValidity("");
    }
  }
};
const handleInputPassword = (event: Event) => {
  const input = event.target as HTMLInputElement;
  checkPasswordMatches();
  emits("update:password", input.value);
};
const handleInputConfirmPassword = (event: Event) => {
  const input = event.target as HTMLInputElement;
  checkPasswordMatches();
  emits("update:confirmPassword", input.value);
};
</script>

<template>
  <div class="my-4">
    <label for="password">{{ $t("labels.password") }}</label>
    <div class="flex h-8">
      <LockClosedIcon class="flex-initial icon" />
      <input
        id="password"
        ref="passwordElement"
        class="flex-shrink text-icon"
        type="password"
        name="password"
        :placeholder="$t('placeholders.password')"
        autocomplete="new-password"
        minlength="8"
        maxlength="100"
        required
        :value="password"
        @input="handleInputPassword"
      />
    </div>
  </div>
  <div class="my-4">
    <label for="confirmPassword">{{ $t("labels.confirmPassword") }}</label>
    <div class="flex h-8">
      <LockClosedIcon class="flex-initial icon" />
      <input
        id="confirmPassword"
        ref="confirmPasswordElement"
        class="flex-shrink text-icon"
        type="password"
        name="confirmPassword"
        :placeholder="$t('placeholders.password')"
        autocomplete="off"
        minlength="8"
        maxlength="100"
        required
        :value="confirmPassword"
        @input="handleInputConfirmPassword"
      />
    </div>
  </div>
</template>
