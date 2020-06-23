import React, { Component } from 'react';
import {Carousel, Button} from 'react-bootstrap';
import img1 from '../assets/pic1.jpg';
import img2 from '../assets/pic2.png';
import img3 from '../assets/pic3.jpg';
import '../css/carousel.css';

export const ImgCarousel = () => (
    <Carousel>
        <Carousel.Item>
            <img className="d-block w-100" src={img1}
            alt="First Slide"/>
            <Carousel.Caption>
                <h2 id="h2_car">Give a gift worth giving</h2>
                <p id="p_car">Let them see your signature and why they won't make
                    it in life
                </p>
                <Button variant="primary" size="lg" href="/visahackathon/#/login" active>Make a Gift</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
            <img className="d-block w-100" src={img2}
            alt="Second Slide"/>
            <Carousel.Caption>
                <h2 id="h2_car">It will only cost you a kidney and three teeth</h2>
                <p id="p_car">So what are you waiting for?
                </p>
              <Button variant="primary" size="lg" href="/visahackathon/#/login" active>I Said Make a Gift</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
            <img className="d-block w-100" src={img3}
            alt="Second Slide"/>
            <Carousel.Caption>
            <h2 id="h2_car">Do you like living?</h2>
                <p id="p_car">Well, let me tell you something...
                </p>
              <Button variant="primary" size="lg" href="/visahackathon/#/login" active>If You Don't Make a Gift, I Will Literally Stab You</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
    </Carousel>
)