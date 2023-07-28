<script>

    import {onMount} from "svelte";

    export let prompt
    export let index
    export let reaction
    export let sendReaction

    let counter = 0
    let upOrDown = true;


    onMount(() => {

        if (reaction[index] !== undefined) {
            counter = reaction[index].count
        }
    })

    function counterUp() {
        if (upOrDown) {
            counter++
            upOrDown = false
        } else {
            counter--
            upOrDown = true
        }
    }


</script>


<div class="flex place-content-between pr-14">
    <p class="xs:text-sm md:text-[2.625rem]">{prompt}</p>
    <div class="bg-gradient-to-b from-neutral-400 xs:scale-50 md:scale-100 to-[110%] bg-opacity-20 p-[2px] rounded-2xl mb-3">

        {#if reaction[index] === undefined}
            <button on:click={counterUp}
                    class="rounded-2xl  px-3 bg-neutral-600 opacity-100 shadow-sharp bg-opacity-100">{prompt.substring(0, 2)}{counter}
            </button>
        {:else}
            <button on:click={counterUp} on:click={() => sendReaction(reaction[index].emoji)}
                    class="rounded-2xl px-3 bg-neutral-600 opacity-100 shadow-sharp bg-opacity-100">{reaction[index].emoji} {counter}</button>

        {/if}
    </div>
</div>