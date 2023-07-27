<script lang="ts">

    import {Client} from '@stomp/stompjs';
    import Card from "./Card.svelte";
    import axios from "axios";
    import {Wyrs} from "../stores/wyrStore.js";
    import {onDestroy, onMount} from "svelte";
    import CreateCard from "./CreateCard.svelte";

    let creating = true


    const stompClient = new Client({
        brokerURL: "ws://localhost:8080/gs-guide-websocket",

    })

    Wyrs.set(axios({
            method: 'get',
            url: "http://localhost:8080/getAllWyr",
            withCredentials: false,
        }).then(resp => resp.data).then((DATA) => Wyrs.set(DATA))
    )

    stompClient.onConnect = function (frame) {
        stompClient.subscribe("/topic/receivewyr", greeting => {
            $Wyrs = [...$Wyrs, JSON.parse(greeting.body)]
        })
    }


    onMount(() => {
        stompClient.debug = f => f
        stompClient.activate()

    })

    onDestroy(() => {
        stompClient.deactivate()
    })


    let createwyr = (channelId) => {

        stompClient.publish({
            destination: "/socket/wyr",
            body: JSON.stringify({
                "title": "Socket WYR",
                "prompts": ["✅ prompt 1", "🤡 prompt 2"],
                "reactions": [],
                "user": {
                    "discordId": "237596924167979008"
                }
            })
        })

        axios({
            method: "post",
            url: `https://discord.com/api/v10/channels/${channelId}/messages`,
            headers: {
                Authorization: localStorage.getItem("UserToken")
            },
            data: {
                content: "<:WYR:1104136817751633970> Wow this is crazy\n🙋  clown emoji\n💎  steen meneer\n🫄  man die meer kan zien"
            }
        })
    }


</script>


<div class="flex bg-neutral-800 w-[calc(100vw-20rem)] h-[calc(100vh-5.6rem)] overflow-scroll  rounded-tl-2xl rou pl-10 flex-col ml-20 ">
    <div class="flex place-items-center flex-col overflow-auto">
        <div>
            <!--<button class="text-white text-4xl" on:click={() => createwyr("1103388742976286742")}>SendWyr</button>-->
            {#if creating}
                <h1 class="text-[3rem] text-white font-bold font-sans ">WYR</h1>
                {#await $Wyrs}
                    <p>Waiting...</p>
                {:then response}
                    {#each response as wyrs}
                        <Card {wyrs}/>

                    {/each}
                {:catch error}
                    <p>Oops er is iets misgegaan {error}</p>
                {/await}
                <!--            <Card/>-->
                <!--            <Card/>-->
            {:else}
                <CreateCard type="WYR"/>
            {/if}

        </div>
    </div>
</div>
