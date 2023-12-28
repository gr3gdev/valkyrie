<script setup lang="ts">
// see https://emojipedia.org/
const locales = [
  {
    key: "en",
    name: "English",
    flag: "🏴󠁧󠁢󠁥󠁮󠁧󠁿",
  },
  {
    key: "fr",
    name: "Français",
    flag: "🇫🇷",
  },
];
</script>

<template>
  <div class="locale-changer">
    <label for="select-locale">{{ $t("select.locale") }}</label>
    <select id="select-locale" v-model="$i18n.locale" name="select-locale">
      <option v-for="locale in locales" :key="`locale-${locale.key}`" :value="locale.key">
        {{ locale.flag }}&nbsp;{{ locale.name }}
      </option>
    </select>
  </div>
</template>
