import React from 'react';

const HeroSection: React.FC = () => {
  return (
    <section className="hero-section">
      <div className="hero-overlay"></div>
      <div className="hero-content">
        <h2 className="hero-title">
          Together we can move the needle of{' '}
          <em className="highlight">diversity in tech.</em>
        </h2>
        <div className="hero-text">
          <span>Code Differently</span> provides hands on training...
        </div>
      </div>
    </section>
  );
};

export default HeroSection;
