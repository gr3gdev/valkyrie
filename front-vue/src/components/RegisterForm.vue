<script setup lang="ts">
import { LockClosedIcon, UserIcon } from '@heroicons/vue/24/solid';
</script>

<template>
    <form action="/register" method="post" class="mx-auto">
        <div class="my-4">
            <label for="firstname">{{ $t("labels.firstname") }}</label>
            <div class="flex h-8">
                <UserIcon class="flex-initial icon" />
                <input class="flex-shrink text-icon" type="text" id="firstname" name="firstname" placeholder="Firstname"
                    autocomplete="given-name" />
            </div>
        </div>
        <div class="my-4">
            <label for="lastname">{{ $t("labels.lastname") }}</label>
            <div class="flex h-8">
                <UserIcon class="flex-initial icon" />
                <input class="flex-shrink text-icon" type="text" id="lastname" name="lastname" placeholder="Lastname"
                    autocomplete="family-name" />
            </div>
        </div>
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
                    autocomplete="new-password" />
            </div>
        </div>
        <div class="my-4">
            <label for="confirmPassword">{{ $t("labels.confirmPassword") }}</label>
            <div class="flex h-8">
                <LockClosedIcon class="flex-initial icon" />
                <input class="flex-shrink text-icon" type="password" id="confirmPassword" name="confirmPassword"
                    placeholder="Confirm password" autocomplete="off" />
            </div>
        </div>
        <button type="submit">{{ $t("buttons.register") }}</button>
    </form>
    <div class="form-footer">
    <router-link to="/login">{{ $t("backToLogin") }}</router-link>
</div></template>
