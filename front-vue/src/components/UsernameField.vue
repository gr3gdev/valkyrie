<script setup lang="ts">
import { UserIcon } from "@heroicons/vue/24/solid";
defineProps({
  username: {
    default: "",
    type: String,
  },
});
const emits = defineEmits(["update:username"]);
const handleInput = (event: Event) => {
  const input = event.target as HTMLInputElement;
  emits("update:username", input.value);
};
</script>

<template>
  <div class="my-4">
    <label for="username">{{ $t("labels.username") }}</label>
    <div class="flex h-8">
      <UserIcon class="flex-initial icon" />
      <input
        id="username"
        class="flex-shrink text-icon"
        type="text"
        name="username"
        :placeholder="$t('placeholders.username')"
        autocomplete="username"
        minlength="4"
        maxlength="32"
        required
        :value="username"
        @input="handleInput"
      />
    </div>
  </div>
</template>
