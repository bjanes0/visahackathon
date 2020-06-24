import React, { Component } from 'react';
import { Carousel, Button } from 'react-bootstrap';
import img1 from '../assets/pic1.jpg';
import img2 from '../assets/pic2.png';
import img3 from '../assets/pic3.jpg';
import '../css/carousel.css';

export const ImgCarousel = () => (
    <Carousel>
        <Carousel.Item>
            <img className="d-block w-100" src={img1}
                alt="First Slide" />
            <Carousel.Caption>
                <h2 id="h2_car">Give a gift worth giving</h2>
                <p id="p_car">Give your friend a nice present
                </p>
                <Button id="car_button"variant="secondary" size="lg" href="/visahackathon/#/login" active>Make a Gift</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
            <img className="d-block w-100" src={img2}
                alt="Second Slide" />
            <Carousel.Caption>
                <h2 id="h2_car">Your friend wants a gift really bad</h2>
                <p id="p_car">So what are you waiting for?
                </p>
                <Button id="car_button"variant="secondary" size="lg" href="/visahackathon/#/login" active>I Said Make a Gift</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
            <img className="d-block w-100" src={img3}
                alt="Second Slide" />
            <Carousel.Caption>
                <h2 id="h2_car">Please make a gift</h2>
                <p id="p_car">you can use this button right here
                </p>
                <Button id="car_button"variant="secondary" size="lg" href="/visahackathon/#/login" active>Make a Gift Now</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
    </Carousel>
)