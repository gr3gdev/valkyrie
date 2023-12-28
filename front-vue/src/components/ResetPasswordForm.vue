<script setup lang="ts">
import { UserIcon } from '@heroicons/vue/24/solid';
</script>

<template>
    <form action="/resetPassword" method="post" class="mx-auto">
        <div class="my-4">
            <label for="username">{{ $t("labels.username") }}</label>
            <div class="flex h-8">
                <UserIcon class="flex-initial icon" />
                <input class="flex-shrink text-icon" type="text" id="username" name="username" placeholder="Username"
                    autocomplete="username" />
            </div>
        </div>
        <button type="submit">{{ $t("buttons.reset") }}</button>
    </form>
    <div class="form-footer">
        <router-link to="/login">{{ $t("backToLogin") }}</router-link>
    </div>
</template>
