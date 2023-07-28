<script>
    import Prompt from "./Prompt.svelte";
    import axios from "axios";

    let src = "/profile.webp"
    let naam = "remco";

    export let wyrs


    const reaction = (emoji) => {
        axios({
            method: "put",
            headers: {
                'Authorization':
                    localStorage.getItem("DiscordToken")
            },
            url: `https://discord.com/api/v10/channels/${wyrs.channelId}/messages/${wyrs.messageId}/reactions/${emoji}/@me`,
        })
    }


</script>

<div class="w-[100%] ">
    <div class="font-bold  2xl:w-[66.25rem] xl:w-[calc(80vw)]  p-4 rounded-2xl shadow-sharp mb-5 bg-neutral-700">
        <h2 class="text-[2.625rem] pb-2 text-white ">{wyrs.title}</h2>

        <div class="flex">
            <img class="w-[3.7rem] rounded-2xl" {src}/>
            <div class="ml-3  text-white font-sans text-[1rem]">
                <p>{naam}</p>
                <p class="font-mono opacity-60 ">{wyrs.timeCreated}</p>
            </div>
        </div>
        <div class="py-5 text-[2rem] text-white font-bold">

            {#each wyrs.prompts as prompt, i}
                <Prompt reaction={wyrs.reactions} index={i} {prompt} sendReaction={reaction}/>
            {/each}
        </div>

    </div>
</div>
