<script>
    export let type
    let PromptAmount = 1




</script>


<div class="w-[66.25rem] font-bold p-4 rounded-2xl shadow-sharp mb-5 bg-neutral-700 flex flex-col place-items-center">
    <h1 class="text-[3rem] text-white font-bold font-sans text-center">Maak een nieuwe {type}!</h1>


    <button class="bg-red-400 p-4 rounded-lg shadow-sharp w-1/2  text-xl text-white font-sans text-center" on:click={PromptAmount++}>Nieuwe prompt</button>
</div>