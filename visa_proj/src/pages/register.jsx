import React, { Component } from 'react';
import { Form, Button, Container, Row, Col, InputGroup } from 'react-bootstrap';
import '../css/register.css';
import { Formik } from 'formik';
import * as yup from 'yup'


const schema = yup.object({
    firstName: yup.string().required(),
    lastName: yup.string().required(),
    email: yup.string().required("Email is required").email("Must be a valid email"),
    dob: yup.string().required("DOB is required"),
    phone: yup.string().required("Phone is required"),
    password: yup.string().required("Password is required"),
    confirmPassword: yup.string().required("You must confirm your password").oneOf([yup.ref('password'), null], 'Passwords must match'),
});

export const Register = () => (
    <React.Fragment>
        <Container fluid>
            <Row>
                <Col></Col>
                <Col id="col_register">
                    <br />
                    <br />
                    <br />
                    <br />
                    <Formik
                        validationSchema={schema}
                        onSubmit={console.log}
                        initialValues={{
                            firstName: '',
                            lastName: '',
                        }}
                    >
                        {({
                            handleSubmit,
                            handleChange,
                            handleBlur,
                            values,
                            touched,
                            isValid,
                            errors,
                        }) => (
                                <Form noValidate onSubmit={handleSubmit}>
                                    <Form.Row>
                                        <Form.Group as={Col} md="6" controlId="validationFormik01">
                                            <Form.Label>First name</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="First name"
                                                name="firstName"
                                                value={values.firstName}
                                                onChange={handleChange}
                                                isValid={touched.firstName && !errors.firstName}
                                            />
                                            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                                        </Form.Group>
                                        <Form.Group as={Col} md="6" controlId="validationFormik02">
                                            <Form.Label>Last name</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Last name"
                                                name="lastName"
                                                value={values.lastName}
                                                onChange={handleChange}
                                                isValid={touched.lastName && !errors.lastName}
                                            />
                                            <Form.Control.Feedback type="valid">Looks good!</Form.Control.Feedback>
                                        </Form.Group>
                                    </Form.Row>
                                    <Form.Row>
                                        <Form.Group as={Col} md="12" controlId="validationFormik03">
                                            <Form.Label>Email</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Email"
                                                name="email"
                                                value={values.email}
                                                onChange={handleChange}
                                                isValid={touched.email && !errors.email}
                                                isInvalid={touched.email && !!errors.email}
                                            />
                                            <Form.Control.Feedback type="invalid">
                                                {errors.email}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                    </Form.Row>
                                    <Form.Row>
                                        <Form.Group as={Col} md="6" controlId="validationFormik04">
                                            <Form.Label>Date of Birth (MM-DD-YYYY)</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Date of Birth"
                                                name="dob"
                                                value={values.dob}
                                                onChange={handleChange}
                                                isValid={touched.dob && !errors.dob}
                                                isInvalid={touched.dob && !!errors.dob}
                                            />
                                            <Form.Control.Feedback type="invalid">
                                                {errors.dob}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                        <Form.Group as={Col} md="6" controlId="validationFormik05">
                                            <Form.Label>Phone #</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Phone #"
                                                name="phone"
                                                value={values.phone}
                                                onChange={handleChange}
                                                isValid={touched.phone && !errors.phone}
                                                isInvalid={touched.phone && !!errors.phone}
                                            />

                                            <Form.Control.Feedback type="invalid">
                                                {errors.phone}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                    </Form.Row>
                                    <Form.Row>
                                        <Form.Group as={Col} md="6" controlId="validationFormik06">
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Password"
                                                name="password"
                                                value={values.password}
                                                onChange={handleChange}
                                                isValid={touched.password && !errors.password}
                                                isInvalid={touched.password && !!errors.password}
                                            />

                                            <Form.Control.Feedback type="invalid">
                                                {errors.password}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                        <Form.Group as={Col} md="6" controlId="validationFormik07">
                                            <Form.Label>Confirm Password</Form.Label>
                                            <Form.Control
                                                type="text"
                                                placeholder="Confirm Password"
                                                name="confirmPassword"
                                                value={values.confirmPassword}
                                                onChange={handleChange}
                                                isValid={touched.confirmPassword && !errors.confirmPassword}
                                                isInvalid={touched.confirmPassword && !!errors.confirmPassword}
                                            />

                                            <Form.Control.Feedback type="invalid">
                                                {errors.confirmPassword}
                                            </Form.Control.Feedback>
                                        </Form.Group>
                                    </Form.Row>
                                    <Button variant="secondary" type="submit">Create Account</Button>
                                </Form>
                            )}
                    </Formik>
                </Col>
                <Col></Col>
            </Row>
        </Container>
    </React.Fragment>
)