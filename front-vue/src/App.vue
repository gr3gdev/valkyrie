<script setup lang="ts">
import LocaleSelector from "./components/LocaleSelector.vue";
import LogoSVG from "./assets/valkyrie.svg";
</script>

<template>
  <h1 class="inline-block">
    <LogoSVG aria-label="Valkyrie Logo" class="inline w-12 h-12 fill-green-300" />
    {{ $t("title") }}
  </h1>
  <LocaleSelector />
  <router-view></router-view>
</template>
