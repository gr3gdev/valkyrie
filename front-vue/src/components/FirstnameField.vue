<script setup lang="ts">
import { UserIcon } from "@heroicons/vue/24/solid";
defineProps({
  firstname: {
    default: "",
    type: String,
  },
});
const emits = defineEmits(["update:firstname"]);
const handleInput = (event: Event) => {
  const input = event.target as HTMLInputElement;
  emits("update:firstname", input.value);
};
</script>

<template>
  <div class="my-4">
    <label for="firstname">{{ $t("labels.firstname") }}</label>
    <div class="flex h-8">
      <UserIcon class="flex-initial icon" />
      <input
        id="firstname"
        class="flex-shrink text-icon"
        type="text"
        name="firstname"
        :placeholder="$t('placeholders.firstname')"
        autocomplete="given-name"
        minlength="1"
        maxlength="100"
        required
        :value="firstname"
        @input="handleInput"
      />
    </div>
  </div>
</template>
