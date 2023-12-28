<script setup lang="ts">
import { LockClosedIcon } from "@heroicons/vue/24/solid";
defineProps({
  password: {
    default: "",
    type: String,
  },
});
const emits = defineEmits(["update:password"]);
const handleInput = (event: Event) => {
  const input = event.target as HTMLInputElement;
  emits("update:password", input.value);
};
</script>

<template>
  <div class="my-4">
    <label for="password">{{ $t("labels.password") }}</label>
    <div class="flex h-8">
      <LockClosedIcon class="flex-initial icon" />
      <input
        id="password"
        class="flex-shrink text-icon"
        type="password"
        name="password"
        :placeholder="$t('placeholders.password')"
        autocomplete="current-password"
        minlength="8"
        maxlength="100"
        required
        :value="password"
        @input="handleInput"
      />
    </div>
  </div>
</template>
