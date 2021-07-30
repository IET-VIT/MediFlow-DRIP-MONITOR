<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/github_username/repo_name">
    <img src="images/logo.png" alt="Logo" width="355.630965006" height="160">
  </a>

  <h3 align="center">DRIP MONITOR</h3>

  <p align="center">
    A Smart Drip that allows efficient and constant monitoring of various aspects of the patient.
    <br />
    <a href="https://github.com/github_username/repo_name"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/github_username/repo_name">View Demo</a>
    ·
    <a href="https://github.com/github_username/repo_name/issues">Report Bug</a>
    ·
    <a href="https://github.com/github_username/repo_name/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![image](https://user-images.githubusercontent.com/76275812/113965879-d1842680-984b-11eb-9123-1319eb61bb4a.png)

This project elaborates a way to efficiently monitor the drip level at hospitals, while also detecting any bubble formation in the liquid used; a process that is currently done manually by nurses when they periodically check the drip. In addition to the functional efficiency of this project, it is also cost-effective. With the use of a light sensor, an ultrasonic sensor, a light source, and a microcontroller system, we provide a way to automatically monitor the drip levels. An accompanying app notifies the concerned hospital staff about issues and irregularities pertaining to the drip bottle.


### Built With

* Arduino Uno
* HCSR-04 Ultrasonic Sensor
* Photo-resistor/light sensor
* Light source 
* Esp8266-01 wifi module
* ANDROID STUDIO



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

* Understanding about the working of sensors(Ultrasonic and LDR).
* Understanding of Arduino or a similar microcontroller and integration of the modules with the microcontroller
* Basics of firebase and reading data from a website using firebase and WiFi Module.
* Knowledge of basics of Java and API calling.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/Kaustubh251002/Drip-Monitor/
   ```
2. Install NPM packages
   ```sh
   npm install
   ```



<!-- USAGE EXAMPLES -->
## Usage
This project greatly increases the efficiency of the hospital staff as a whole. The pandemic has led to a lot of hospitals being completely occupied, and the hostel staff overwhelmed. By not having to conduct manual routine checks on the drip levels and drip conditions of every patient, the workload of the hospital staff is exceedingly diminished. Automation in such essential tasks is the next step towards providing more efficient and convenient healthcare.

![image](https://user-images.githubusercontent.com/76275812/113965387-e0b6a480-984a-11eb-8257-ee88194a1fce.png)
![image](https://user-images.githubusercontent.com/76275812/113965453-05128100-984b-11eb-9aae-6446cb0986b2.png)

# Working:
The block diagram above represents the correct working of the model in that first it will measure the level of solution left in the bottle through the ultrasonic sensor and if there are any bubbles formed in that solution and due to which there is an obstacle in the path of the flowing solution through a drip that will be detected by the LDR. The data produced by the ultrasonic sensor and LDR  will be sent to the firebase through the ESP8266 module. The same data will be sent to the Mobile App, where appropriate warnings can be conveyed to the staff.

<!-- ROADMAP -->
## Roadmap
To make our system more useful and convenient, we plan on adding a one touch communication portal, through which the patient or their family member can request for assistance from a nurse instead of the family member going out to call them, leaving the patient unattended. Apart from this we will switch from displaying a constant message of the flowing drip and bubble formation, to a pop-up, non-dismissable warning message, for a more efficient and user friendly application.


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Your Name - [@Kaustub22315199](https://twitter.com/Kaustub22315199) - kmishra2510@gmail.com

Project Link: [https://github.com/Kaustubh251002/Drip-Monitor/](https://github.com/Kaustubh251002/Drip-Monitor/)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [Samanyu Okade](https://github.com/Samanyu-007)
* [Bhavya Goel](https://github.com/bhavyagoel)
* [Sai Sukesh](https://github.com/saisukesh04)


<p align="center">
	With :heart: by <a href="https://ietvit.tech/" target="_blank">Team Fourth Dimension, IET-VIT</a>
</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/github_username












