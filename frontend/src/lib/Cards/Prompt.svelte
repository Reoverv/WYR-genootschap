<script>

    import {onMount} from "svelte";


    export let prompt
    export let index
    export let reaction
    export let sendReaction


    $: promptsplit = prompt.split(" ")
    $: promptsentece = promptsplit.slice(1).toString().replace(/,/g, " ")

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


<div class="flex place-content-between  sm:pr-0">
    <div class="flex">
        <p class="xs:text-xl md:text-[2.625rem] ">{promptsplit[0]}</p>
        <p class="xs:text-xl md:text-[2.625rem] ">{promptsentece}</p>

    </div>
    <div class="flex max-h-14  ">

        <div class="bg-gradient-to-b   from-neutral-400  xs:scale-50 md:scale-100 to-[110%] bg-opacity-20 p-[2px] rounded-2xl ">

            {#if reaction[index] === undefined}
                <button on:click={counterUp}
                        class="rounded-2xl items-center  px-3  bg-neutral-600  shadow-sharp">{prompt.substring(0, 2)}{counter}
                </button>
            {:else}
                <button on:click={counterUp} on:click={() => sendReaction(reaction[index].emoji)}
                        class="rounded-2xl   items-center px-3 whitespace-nowrap bg-neutral-600  shadow-sharp">{reaction[index].emoji} {counter}</button>
            {/if}
        </div>
    </div>
</div>