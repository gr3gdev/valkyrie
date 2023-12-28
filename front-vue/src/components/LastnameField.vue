<script setup lang="ts">
import { UserIcon } from "@heroicons/vue/24/solid";
defineProps({
  lastname: {
    default: "",
    type: String,
  },
});
const emits = defineEmits(["update:lastname"]);
const handleInput = (event: Event) => {
  const input = event.target as HTMLInputElement;
  emits("update:lastname", input.value);
};
</script>

<template>
  <div class="my-4">
    <label for="lastname">{{ $t("labels.lastname") }}</label>
    <div class="flex h-8">
      <UserIcon class="flex-initial icon" />
      <input
        id="lastname"
        class="flex-shrink text-icon"
        type="text"
        name="lastname"
        :placeholder="$t('placeholders.lastname')"
        autocomplete="family-name"
        minlength="1"
        maxlength="100"
        required
        :value="lastname"
        @input="handleInput"
      />
    </div>
  </div>
</template>
