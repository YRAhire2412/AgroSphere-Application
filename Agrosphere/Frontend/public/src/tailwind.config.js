// /** @type {import('tailwindcss').Config} */
// module.exports = {
//     content: [
//       "./src/**/*.{js,jsx,ts,tsx}",  // Ensure Tailwind scans your source files
//       "./public/index.html"
//     ],
//     theme: {
//       extend: {
//         colors: {
//           primary: '#4caf50',    // Green for primary buttons and elements
//           secondary: '#8d6e63',  // Earthy brown tone
//           accent: '#ffc107',     // Golden accent for highlights
//           dark: '#2e3b55'        // Dark color for contrast
//         },
//         fontFamily: {
//           sans: ['Inter', 'sans-serif'],  // Set a modern sans-serif font
//           heading: ['Poppins', 'sans-serif']
//         },
//         boxShadow: {
//           card: '0 4px 8px rgba(0, 0, 0, 0.1)', // Custom shadow for cards
//         }
//       }
//     },
//     plugins: [
//       require('@tailwindcss/forms'),      // Styled form elements
//       require('@tailwindcss/typography') // Better typography styles
//     ],
//   }
  /** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
      "./src/**/*.{js,jsx,ts,tsx}",
    ],
    theme: {
      extend: {},
    },
    plugins: [],
  }
  