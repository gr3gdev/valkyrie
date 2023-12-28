<script setup lang="ts">
import { LockClosedIcon, UserIcon } from '@heroicons/vue/24/solid';
</script>

<template>
    <form action="/login" method="post" class="mx-auto">
        <div class="my-4">
            <label for="username">{{ $t("labels.username") }}</label>
            <div class="flex h-8">
                <UserIcon class="flex-initial icon" />
                <input class="flex-shrink text-icon" type="text" id="username" name="username" placeholder="Username"
                    autocomplete="username" />
            </div>
        </div>
        <div class="my-4">
            <label for="password">{{ $t("labels.password") }}</label>
            <div class="flex h-8">
                <LockClosedIcon class="flex-initial icon" />
                <input class="flex-shrink text-icon" type="password" id="password" name="password" placeholder="Password"
                    autocomplete="current-password" />
            </div>
        </div>
        <button type="submit">{{ $t("buttons.login") }}</button>
    </form>
    <div class="my-4">
        <router-link to="/resetPassword">{{ $t("labels.forgotPassword") }}</router-link>
    </div>
    <div class="form-footer">
        {{ $t("newUser") }}
        <router-link to="/register">{{ $t("buttons.register") }}</router-link>
    </div>
</template>
