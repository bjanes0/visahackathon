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
                <p id="p_car">Visa Touch makes it easy to add a special touch to a virtual gift
                </p>
                <Button id="car_button" variant="secondary" size="lg" href="/visahackathon/#/my-gifts" active>Make a Gift</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
            <img className="d-block w-100" src={img2}
                alt="Second Slide" />
            <Carousel.Caption>
                <h2 id="h2_car">Trying to find a gift?</h2>
                <p id="p_car">Search for a gift!
                </p>
                <Button id="car_button" variant="secondary" size="lg" href="/visahackathon/#/search" active>Search Now</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
            <img className="d-block w-100" src={img3}
                alt="Second Slide" />
            <Carousel.Caption>
                <h2 id="h2_car">Check out different templates!</h2>
                <p id="p_car">There's plenty of ways to customize your gift for a personal feel
                </p>
                <Button id="car_button" variant="secondary" size="lg" href="/visahackathon/#/my-gifts" active>Make a Gift Now!</Button>{' '}
            </Carousel.Caption>
        </Carousel.Item>
    </Carousel>
)