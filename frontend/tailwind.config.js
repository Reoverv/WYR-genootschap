/** @type {import('tailwindcss').Config} */
export default {
  content: ['./src/**/**.{html,js,svelte,ts}'],
  theme: {
    "fontFamily":{
      'sans': ['poppins', 'ui-sans-serif', 'system-ui']
    },
    extend: {
      boxShadow: {
        'sharp': '0px 5px 10px 0px rgba(0,0,0,0.35)'
      }
    }
  },
  plugins: []
};