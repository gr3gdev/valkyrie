<script setup lang="ts">
import { AtSymbolIcon } from "@heroicons/vue/24/solid";
import { ref } from "vue";
const emailElement = ref(null);
const confirmEmailElement = ref(null);
const props = defineProps({
  email: {
    default: "",
    type: String,
  },
  confirmEmail: {
    default: "",
    type: String,
  },
  errorMismatch: {
    default: "Emails are not the same",
    type: String,
  },
});
const emits = defineEmits(["update:email", "update:confirmEmail"]);
const checkEmailMatches = () => {
  if (emailElement.value && confirmEmailElement.value) {
    const email = emailElement.value as HTMLInputElement;
    const confirmEmail = confirmEmailElement.value as HTMLInputElement;
    const emailValue = email.value;
    const confirmEmailValue = confirmEmail.value;
    if (emailValue && confirmEmailValue && emailValue !== confirmEmailValue) {
      confirmEmail.setCustomValidity(props.errorMismatch);
    } else {
      confirmEmail.setCustomValidity("");
    }
  }
};
const handleInputEmail = (event: Event) => {
  const input = event.target as HTMLInputElement;
  checkEmailMatches();
  emits("update:email", input.value);
};
const handleInputConfirmEmail = (event: Event) => {
  const input = event.target as HTMLInputElement;
  checkEmailMatches();
  emits("update:confirmEmail", input.value);
};
</script>

<template>
  <div class="my-4">
    <label for="email">{{ $t("labels.email") }}</label>
    <div class="flex h-8">
      <AtSymbolIcon class="flex-initial icon" />
      <input
        id="email"
        ref="emailElement"
        class="flex-shrink text-icon"
        type="email"
        name="email"
        placeholder="address@email.com"
        autocomplete="email"
        required
        :value="email"
        @input="handleInputEmail"
      />
    </div>
  </div>
  <div class="my-4">
    <label for="confirmEmail">{{ $t("labels.confirmEmail") }}</label>
    <div class="flex h-8">
      <AtSymbolIcon class="flex-initial icon" />
      <input
        id="confirmEmail"
        ref="confirmEmailElement"
        class="flex-shrink text-icon"
        type="email"
        name="confirmEmail"
        placeholder="address@email.com"
        autocomplete="off"
        required
        :value="confirmEmail"
        @input="handleInputConfirmEmail"
      />
    </div>
  </div>
</template>
